package net.sendukbesi.springbootrest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.sendukbesi.springbootrest.exception.ResourceNotFoundException;
import net.sendukbesi.springbootrest.toilet.ModelToiletUser;
import net.sendukbesi.springbootrest.toilet.RepoToiletUser;
import net.sendukbesi.springbootrest.util.BaseController;
import net.sendukbesi.springbootrest.util.BaseUtil;
import net.sendukbesi.springbootrest.util.MessageResponse;
import net.sendukbesi.springbootrest.util.SendukErrorCodeEnum;

@CrossOrigin(origins = {"*"}, maxAge = 3600, allowCredentials = "false")
@RestController
@RequestMapping("/api/v1")
@Api(value = "Toilet Management System")
public class ControllerToiletUser extends BaseController{
	
	@Autowired
    private RepoToiletUser userToiletRepository;
	
	
	@GetMapping("/alltoiletuser")
    public MessageResponse getAllToiletUser() {
    	List <ModelToiletUser> userToilet = userToiletRepository.findAll();
    	if(!BaseUtil.isObjNull(userToilet)) {
    		return new MessageResponse(SendukErrorCodeEnum.SENDUK001, userToilet);
    	} else {
    		return new MessageResponse(SendukErrorCodeEnum.SENDUK005, null);
    	}
    }
	
	@GetMapping("/toiletuser/{id}")
    public MessageResponse getToiletUserById(@PathVariable("id") Long toiletUserId) {
        Optional<ModelToiletUser> userToilet = userToiletRepository.findById(toiletUserId);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, userToilet);
    }

    @PostMapping("/toiletuser")
    public MessageResponse createToiletUser(ModelToiletUser toiletUser) {
    	for (ModelToiletUser userToilet : userToiletRepository.findAll()) {
    		if(userToilet.getEmail().equalsIgnoreCase(toiletUser.getEmail())) {
    			return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "Duplicate Toilet User.Please use new email");
    		}
    	}
    	userToiletRepository.save(toiletUser);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "create toilet user success");
    }
    
    @PutMapping("/toiletuser/{id}")
    public MessageResponse updateToiletUser(@PathVariable(value = "id") Long toiletUserId,
        @Valid @RequestBody ModelToiletUser toiletUserDetails) throws ResourceNotFoundException {
    	ModelToiletUser userToilet = userToiletRepository.findById(toiletUserId)
            .orElseThrow(() -> new ResourceNotFoundException("Toilet User not found for this id :: " + toiletUserId));

    	userToilet.setName(toiletUserDetails.getName());
    	userToilet.setEmail(toiletUserDetails.getEmail());
    	userToilet.setPassword(toiletUserDetails.getPassword());
    	userToilet.setPhoneNumber(toiletUserDetails.getPhoneNumber());
    	userToilet.setWallet(toiletUserDetails.getWallet());
        final ModelToiletUser updatedToiletUser = userToiletRepository.save(userToilet);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "update success");
    }

    @DeleteMapping("/toiletuser/{id}")
    public MessageResponse deleteToiletUser(@PathVariable(value = "id") Long toiletUserId)
    throws ResourceNotFoundException {
    	ModelToiletUser userToilet = userToiletRepository.findById(toiletUserId)
            .orElseThrow(() -> new ResourceNotFoundException("Toilet User not found for this id :: " + toiletUserId));

        userToiletRepository.delete(userToilet);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "delete success");
    }

}
