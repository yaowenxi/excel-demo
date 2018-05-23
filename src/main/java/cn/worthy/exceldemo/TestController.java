package cn.worthy.exceldemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author:yaowenxi
 * Date: 2018/5/22
 */
@Controller
@RequestMapping
public class TestController {

    /**
     * Save the uploaded file to this folder
     */
    private static String UPLOADED_FOLDER = "D://temp//";

    @GetMapping(value = "/test")
    public String test(){
        return "test conn";
    }

    @GetMapping("/")
    public String index(){
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        System.out.println(file.getOriginalFilename());
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
