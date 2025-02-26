package org.sid.controller;



import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.Frame;
import org.bytedeco.opencv.opencv_core.Mat;
import org.sid.model.User;
import org.sid.service.FaceRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/face")
public class FaceRecognitionController {

    @Autowired
    private FaceRecognitionService faceRecognitionService;

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestBody ImageData imageData) throws IOException {
        InputStream is = new ByteArrayInputStream(ImageData.getImage());
        BufferedImage bufferedImage = ImageIO.read(is);
        OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();
        Frame frame = converter.convert(bufferedImage);
        Mat matImage = converter.getMat(frame);

        faceRecognitionService.registerUser(username, matImage);
        return "Utilisateur enregistré avec succès!";
    }

    @PostMapping("/recognize")
    public Long recognizeFace(@RequestBody ImageData imageData) throws IOException {
        InputStream is = new ByteArrayInputStream(imageData.getImage());
        BufferedImage bufferedImage = ImageIO.read(is);
        OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();
        Frame frame = converter.convert(bufferedImage);
        Mat matImage = converter.getMat(frame);

        return faceRecognitionService.recognizeFace(matImage);
    }
}
