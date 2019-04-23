package com.cdhotel.controller.fileUploadAndDown;

import com.cdhotel.common.LoggerUtils;
import com.cdhotel.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 */
@Controller
public class FileController extends BaseController {

    @RequestMapping("/upload")
    public String fileUpload(){
        LoggerUtils.info(logger,"file ");
        return "fileUpload/upload";
    }

    @PostMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return "上传文件为空，请选择上传文件！";
        }
        String fileName = file.getName();
        String originalFilename = file.getOriginalFilename();
        logger.info(fileName+"_____>"+originalFilename);
        return null;
    }
}
