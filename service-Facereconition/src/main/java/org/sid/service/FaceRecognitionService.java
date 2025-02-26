package org.sid.service;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacv.*;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_face.FaceRecognizer;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;
import org.sid.model.User;
import org.sid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaceRecognitionService {

    @Autowired
    private UserRepository userRepository;

    private FaceRecognizer faceRecognizer;
    private List<Mat> trainingImages = new ArrayList<>();
    private List<Integer> labels = new ArrayList<>();

    public FaceRecognitionService() {
        faceRecognizer = LBPHFaceRecognizer.create();
    }

    public void registerUser(String username, Mat faceImage) {
        User user = new User();
        user.setUsername(username);

        // Convertir l'image en tableau de bytes
        BytePointer bytePointer = new BytePointer();
        opencv_imgcodecs.imencode(".jpg", faceImage, bytePointer); // Utiliser imencode de JavaCV

        byte[] imageBytes = new byte[(int) bytePointer.limit()];
        bytePointer.get(imageBytes);
        user.setFaceData(imageBytes);

        userRepository.save(user);
        trainingImages.add(faceImage);
        labels.add(user.getId()); // Utiliser l'ID comme label
        faceRecognizer.train(trainingImages, labels);
    }

    public Long recognizeFace(Mat image) {
        int[] label = new int[1];
        double[] confidence = new double[1];
        faceRecognizer.predict(image, label, confidence);
        return (confidence[0] < 100) ? (long) label[0] : null; // Retourne l'ID de l'utilisateur reconnu
    }
}
