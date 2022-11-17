package com.gaurav.quoraapp.controller;
import com.gaurav.quoraapp.Dto.UserDto;
import com.gaurav.quoraapp.Service.UserService;
import com.gaurav.quoraapp.Service.impl.UserServiceImpl;
import com.gaurav.quoraapp.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("update"+"/{id}")
//    @PreAuthorize(HasAnyAuthority.UPDATE_NAME)
    public ResponseEntity< Users > updateUser(@RequestBody Users users, @PathVariable("id") long id){
        return new ResponseEntity<>(userService.updateUpdateUser(users, id), HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List< UserDto >> getAllUser(){
        return new ResponseEntity< List<UserDto> >(userService.getAllUser(),HttpStatus.OK);
    }
    @GetMapping("{uid}")
    public ResponseEntity<Users> getUserById(@PathVariable("uid") Long id){
        return new ResponseEntity<Users>(userService.getUserById(id),HttpStatus.ACCEPTED);
    }
    @GetMapping("/download/users.xlsx")
    public void downloadCsv(HttpServletResponse response) throws IOException {
        //response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=users.xlsx");
        ByteArrayInputStream stream = ExcelFileExporter.contactListToExcelFile(userService.getAllUser());

        System.out.println(stream);
        IOUtils.copy(stream, response.getOutputStream());
    }


  /*  @GetMapping("files"+"/{filename:.+}")
    public ResponseEntity< Resource > downloadFile(@PathVariable String filename) throws IOException {
        Resource file = userService.download(filename);
        Path path = file.getFile()
                .toPath();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);

}*/
}