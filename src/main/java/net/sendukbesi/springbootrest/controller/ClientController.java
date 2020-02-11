package net.sendukbesi.springbootrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sendukbesi.springbootrest.exception.ResourceNotFoundException;
import net.sendukbesi.springbootrest.model.Client;
import net.sendukbesi.springbootrest.repository.ClientRepository;
import net.sendukbesi.springbootrest.util.BaseController;
import net.sendukbesi.springbootrest.util.BaseUtil;
import net.sendukbesi.springbootrest.util.MessageResponse;
import net.sendukbesi.springbootrest.util.SendukErrorCodeEnum;

@RestController
@RequestMapping("/api/v1")
@Api(value = "SendukBesi Management System", description = "SendukBesi Management System")
public class ClientController extends BaseController  {
	
	@Autowired
    private ClientRepository clientRepository;
	
	@ApiOperation(value = "View a list of available client")
	@GetMapping("/client")
    public MessageResponse getAllClient() {
    	List <Client> client = clientRepository.findAll();
    	if(!BaseUtil.isObjNull(client)) {
    		return new MessageResponse(SendukErrorCodeEnum.SENDUK001, client);
    	} else {
    		return new MessageResponse(SendukErrorCodeEnum.SENDUK005, null);
    	}
    }
	
	@ApiOperation(value = "Get client by Id")
	@GetMapping("/client/{id}")
    public MessageResponse getClientById(@PathVariable("id") Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, client);
    }
	
	@ApiOperation(value = "Get client by Id")
    @PostMapping("/createClient")
    public MessageResponse createClient(Client client) {
    	for (Client existClient : clientRepository.findAll()) {
    		if(existClient.getPhoneNumber() == client.getPhoneNumber()) {
    			return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "Duplicate Employee.Please use new phone number");
    		}
    	}
        clientRepository.save(client);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "create success");
    }
	
	@ApiOperation(value = "Update client")
    @PostMapping("/updateClient")
    public MessageResponse updateClient(@RequestParam(value="id") long id, @RequestParam(value="name") String name, @RequestParam(value="phoneNumber") long phoneNumber){
    	Client client = new Client();
    	client.setId(id);
    	client.setName(name);
    	client.setPhoneNumber(phoneNumber);
        clientRepository.save(client);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "update success");
    }
	
	@ApiOperation(value = "Delete client")
    @GetMapping("/deleteClient/{id}")
    public MessageResponse deleteClient(@PathVariable(value = "id") Long clientId)
    throws ResourceNotFoundException {
    	Client client = clientRepository.findById(clientId)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + clientId));

        clientRepository.delete(client);
        return new MessageResponse(SendukErrorCodeEnum.SENDUK001, "delete success");
    }
}
