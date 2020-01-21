package io.redis.jedis.jedisdemo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.redis.jedis.jedisdemo.model.Programmer;
import io.redis.jedis.jedisdemo.services.ProgrammerService;

@RestController
public class ProgrammerController {

	@Autowired
	ProgrammerService programmerService;
	// *******************String Demo*******************//

	@RequestMapping(method = RequestMethod.POST, value = "/programmer-string")
	public void addProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		programmerService.setProgrammerAsString(String.valueOf(programmer.getId()),
				mapper.writeValueAsString(programmer));

	}

	@RequestMapping("/programmer-string/{id}")
	public String readString(@PathVariable String id) {
		return programmerService.getProgrammerAsString(id);

	}

	// *******************LIST Demo*******************//

	// add programmer to list
	@RequestMapping(method = RequestMethod.POST, value = "/programmers-list")
	public void addToProgrammerList(@RequestBody Programmer programmer) {
		programmerService.AddToProgrammersList(programmer);

	}

	// get all programmers from a list
	@RequestMapping("/programmers-list")
	public List<Programmer> getProgrammerListMembers() {
		return programmerService.getProgrammersListMembers();

	}

	// count all programmers in a list
	@RequestMapping("/programmers-list/count")
	public Long getProgrammerListCount() {
		return programmerService.getProgrammersListCount();

	}

	// *******************SET Demo*******************//

	// add programmers to set
	@RequestMapping(method = RequestMethod.POST, value = "/programmers-set")
	public void AddToProgrammerstSet(@RequestBody Programmer... programmers) {
		programmerService.AddToProgrammersSet(programmers);

	}

	// get all programmers from a set
	@RequestMapping(method = RequestMethod.GET, value = "/programmers-set")
	public Set<Programmer> getProgrammersSetMembers() {
		return programmerService.getProgrammersSetMembers();

	}

	// Check if programmer already exists in the set
	@RequestMapping(method = RequestMethod.POST, value = "/programmers-set/member")
	public boolean isSetMember(@RequestBody Programmer programmer) {
		return programmerService.isSetMember(programmer);

	}

	// *****************HASH Demo**********************//

	// add programmer to hash
	@RequestMapping(method = RequestMethod.POST, value = "/programmers-hash")
	public void savePHash(@RequestBody Programmer programmer) {
		programmerService.savePHash(programmer);

	}

	// update programmer in hash
	@RequestMapping(method = RequestMethod.PUT, value = "/programmers-hash")
	public void updatePHash(@RequestBody Programmer programmer) {
		programmerService.updatePHash(programmer);

	}

	// get all programmers from hash
	@RequestMapping(method = RequestMethod.GET, value = "/programmers-hash")
	public Map<Integer, Programmer> FindAllPHash() {
		return programmerService.findAllPHash();

	}

	// get programmer from hash
	@RequestMapping(method = RequestMethod.GET, value = "/programmers-hash/{id}")
	public Programmer FindPInHash(@PathVariable int id) {
		return programmerService.findPInHash(id);

	}

	// delete programmer from hash
	@RequestMapping(method = RequestMethod.DELETE, value = "/programmers-hash/{id}")
	public void deletePhash(@PathVariable int id) {
		programmerService.deletePhash(id);

	}

}
