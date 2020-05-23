package net.sendukbesi.springbootrest.toilet;

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
import io.swagger.annotations.ApiOperation;
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
	
	@ApiOperation(value = "Get all Toilet")
	@GetMapping("/alltoilet")
    public MessageResponse getAllToilet() {
    	List <ModelToilet> toilet = toiletRepository.findAll();
    	if(toilet.size() > 0) {
    		return new MessageResponse(SendukErrorCodeEnum.SENDUK001, toilet);
    	} else {
    		//return new MessageResponse(SendukErrorCodeEnum.SENDUK005, null);
    		
    		ModelToilet toiletz = new ModelToilet();
    		ModelToilet toilet1 = new ModelToilet();
    		ModelToilet toilet2 = new ModelToilet();

    		ModelToiletUser toiletUser = new ModelToiletUser();
    		if (toiletRepository.findByName("Tandas Klia 1") == null) {
    			System.err.println("masuk2");
    			toiletz.setName("Tandas Klia 1");
    			toiletz.setImage("http://www.hawkrentacar.com.my/wp-content/uploads/2016/06/OneRepublic-in-Malaysia-Arrive-KLIA-from-Singapore-7824_0.jpg");
    			toiletz.setLocation("KLIA Airport");
    			toiletz.setPrice(5);
    			toiletz.setUsed(75);
    			toiletz.setRating(4);
    			toiletz.setDuration(1);
    			toiletz.setDescription("Toilet saya ini telah menjadi toilet kegemaran warga KL yang inginkan bersendiririan. Mereka boleh melayari internet secara percuma");
    			toiletz.setToiletOwnerID(0);
    			toiletRepository.save(toiletz);

    			toilet1.setName("Tandas Klia 2");
    			toilet1.setImage("https://themangoroad.com/wp-content/uploads/2019/08/klia_2_01-1400x934.jpg");
    			toilet1.setLocation("KLIA 2 Airport");
    			toilet1.setPrice(10);
    			toilet1.setUsed(175);
    			toilet1.setRating(4);
    			toilet1.setDuration(1);
    			toilet1.setDescription("Toilet saya ini telah menjadi toilet kegemaran warga KLIA yang inginkan bersendiririan. Mereka boleh melayari internet secara percuma");
    			toilet1.setToiletOwnerID(0);
    			toiletRepository.save(toilet1);

    			toilet2.setName("Tandas Klia 3");
    			toilet2.setImage("https://themangoroad.com/wp-content/uploads/2019/08/klia_2_01-1400x934.jpg");
    			toilet2.setLocation("KLIA 3 Airport");
    			toilet2.setPrice(20);
    			toilet2.setUsed(5);
    			toilet2.setRating(2);
    			toilet2.setDuration(1);
    			toilet2.setDescription("Toilet saya ini telah menjadi toilet kegemaran warga KLIA yang inginkan bersendiririan. Mereka boleh melayari internet secara percuma");
    			toilet2.setToiletOwnerID(0);
    			toiletRepository.save(toilet2);

    			toiletUser.setName("Taka");
    			toiletUser.setImage("shorturl.at/uDHL8");
    			toiletUser.setPassword("admin");
    			toiletUser.setPhoneNumber(0111111);
    			toiletUser.setEmail("admin@admin.com");
    			toiletUser.setWallet(50);
    			userToiletRepository.save(toiletUser);
    		}
    		List <ModelToilet> toiletzz = toiletRepository.findAll();
    		return new MessageResponse(SendukErrorCodeEnum.SENDUK001, toiletzz);
    	}
    }
	
	@ApiOperation(value = "Get toilet by ID")
	@GetMapping("/toilet/{id}")
    public MessageResponse getToiletById(@PathVariable("id") Long toiletId) {
        Optional<ModelToilet> toilet = toiletRepository.findById(toiletId);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, toilet);
    }
	
	
	@ApiOperation(value = "Create toilet")
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
    
	
	@ApiOperation(value = "Update toilet")
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
	
	@ApiOperation(value = "Delete toilet")
    @DeleteMapping("/toilet/{id}")
    public MessageResponse deleteToilet(@PathVariable(value = "id") Long toiletId)
    throws ResourceNotFoundException {
    	ModelToilet toilet = toiletRepository.findById(toiletId)
            .orElseThrow(() -> new ResourceNotFoundException("Toilet not found for this id :: " + toiletId));

    	toiletRepository.delete(toilet);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "delete success");
    }
}
