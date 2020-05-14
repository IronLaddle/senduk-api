package net.sendukbesi.springbootrest.toilet;

import java.util.ArrayList;
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
import net.sendukbesi.springbootrest.util.BaseController;
import net.sendukbesi.springbootrest.util.BaseUtil;
import net.sendukbesi.springbootrest.util.MessageResponse;
import net.sendukbesi.springbootrest.util.SendukErrorCodeEnum;


@CrossOrigin(origins = {"*"}, maxAge = 3600, allowCredentials = "false")
@RestController
@RequestMapping("/api/v1")
@Api(value = "Toilet Management System")
public class ControllerToilet extends BaseController {
	
	@Autowired
    private RepoToilet toiletRepository;
	
	@Autowired
    private RepoToiletUser userToiletRepository;
	
	
	@GetMapping("/alltoilet")
    public MessageResponse getAllToilet() {
    	List <ModelToilet> toilet = toiletRepository.findAll();
    	if(!BaseUtil.isObjNull(toilet)) {
    		return new MessageResponse(SendukErrorCodeEnum.SENDUK001, toilet);
    	} else {
    		return new MessageResponse(SendukErrorCodeEnum.SENDUK005, null);
    	}
    }
	
	@GetMapping("/toilet/{id}")
    public MessageResponse getToiletById(@PathVariable("id") Long toiletId) {
        Optional<ModelToilet> toilet = toiletRepository.findById(toiletId);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, toilet);
    }

    @PostMapping("/toilet")
    public MessageResponse createToilet(ModelToilet toilets) {
    	for (ModelToilet toilet : toiletRepository.findAll()) {
    		if(toilet.getName().equalsIgnoreCase(toilets.getName())) {
    			return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "Duplicate Toilet Name.Please use new name");
    		}
    	}
    	ModelToilet tandas = new ModelToilet();
    	tandas.setName(toilets.getName());
    	tandas.setImage(toilets.getImage());
    	tandas.setLocation(toilets.getLocation());
    	tandas.setPrice(toilets.getPrice());
    	tandas.setUsed(0);
    	tandas.setRating(0);
    	tandas.setDuration(toilets.getDuration());
    	tandas.setDescription(toilets.getDescription());
    	tandas.setToiletOwnerID(0);
    	toiletRepository.save(tandas);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "create toilet success");
    }
    
    @PutMapping("/toilet/{id}")
    public MessageResponse updateToilet(@PathVariable(value = "id") Long toiletId,
        @Valid @RequestBody ModelToilet toiletDetails) throws ResourceNotFoundException {
    	ModelToilet toilet = toiletRepository.findById(toiletId)
            .orElseThrow(() -> new ResourceNotFoundException("Toilet not found for this id :: " + toiletId));

    	toilet.setName(toiletDetails.getName());
    	toilet.setImage(toiletDetails.getImage());
    	toilet.setLocation(toiletDetails.getLocation());
    	toilet.setPrice(toiletDetails.getPrice());
    	toilet.setUsed(toiletDetails.getUsed());
    	toilet.setRating(toiletDetails.getRating());
    	toilet.setDuration(toiletDetails.getDuration());
    	toilet.setDescription(toiletDetails.getDescription());
    	toilet.setToiletOwnerID(toiletDetails.getToiletOwnerID());
        final ModelToilet updatedToilet = toiletRepository.save(toilet);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "update success");
    }

    @DeleteMapping("/toilet/{id}")
    public MessageResponse deleteToilet(@PathVariable(value = "id") Long toiletId)
    throws ResourceNotFoundException {
    	ModelToilet toilet = toiletRepository.findById(toiletId)
            .orElseThrow(() -> new ResourceNotFoundException("Toilet not found for this id :: " + toiletId));

    	toiletRepository.delete(toilet);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "delete success");
    }
}
