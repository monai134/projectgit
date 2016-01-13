package springmvc.controller.annotation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/file")
public class UploadController {
	
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest req) throws IOException{
		if(!file.isEmpty()){
			String fileName = "D:/"+new Date().getTime()+ file.getOriginalFilename();
			FileOutputStream os = new FileOutputStream(new File(fileName));
			InputStream is = file.getInputStream();
			
			int b= 0 ;
			while((b=is.read())!=-1){
				os.write(b);
			}
			os.flush();
			os.close();
			is.close();
		}
		
		return "/success";
	}
	
	@RequestMapping("/upload2")
	public String upload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest req) throws IOException{
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(req.getSession().getServletContext());
		if(resolver.isMultipart(req)){
			MultipartHttpServletRequest multiReq = (MultipartHttpServletRequest) req;
			Iterator<String> fileNames = multiReq.getFileNames();
			if(fileNames.hasNext()){
				MultipartFile multiFile = multiReq.getFile(fileNames.next());
				String path = "D:/"+"demoUpload"+ file.getOriginalFilename();
				System.out.println("fileName="+path);
				File desFile = new File(path);
				multiFile.transferTo(desFile);
			}
			
		}
		return "/success";
	}
	
	@RequestMapping("/toUpload")
	public String toUpload(){
		return "/upload";
	}
}
