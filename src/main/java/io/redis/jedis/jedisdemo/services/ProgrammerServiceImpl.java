package io.redis.jedis.jedisdemo.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.redis.jedis.jedisdemo.dao.ProgrammerRepository;
import io.redis.jedis.jedisdemo.model.Programmer;

@Service
public class ProgrammerServiceImpl implements ProgrammerService{

	@Autowired
	ProgrammerRepository repository;
	
	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		repository.setProgrammerAsString(idKey,programmer);
		
	}

	@Override
	public String getProgrammerAsString(String key) {
		return 	repository.getProgrammerAsString(key);
	}

	  //List
	@Override
	public void AddToProgrammersList(Programmer programmer) {
		repository.AddToProgrammersList(programmer);
		
	}

	@Override
	public List<Programmer> getProgrammersListMembers() {
		return  repository.getProgrammersListMembers();
	}

	@Override
	public Long getProgrammersListCount() {
		return repository.getProgrammersListCount();
	}

	@Override
	public void AddToProgrammersSet(Programmer... programmers) {
		repository.AddToProgrammersSet( programmers);
		
	}

	@Override
	public Set<Programmer> getProgrammersSetMembers() {
		return repository.getProgrammersSetMembers();
	}

	@Override
	public boolean isSetMember(Programmer programmer) {
		return repository.isSetMember(programmer); 
	}

	 //Hash
	
	@Override
	public void savePHash(Programmer programmer) {
		repository.saveHash(programmer);
		
	}

	@Override
	public void updatePHash(Programmer programmer) {
		repository.updateHash( programmer);
		
	}

	@Override
	public Map<Integer, Programmer> findAllPHash() {
		// TODO Auto-generated method stub
		return repository.findAllHash();
	}

	@Override
	public Programmer findPInHash(int id) {
		// TODO Auto-generated method stub
		return repository.findInHash( id);
	}

	@Override
	public void deletePhash(int id) {
		repository.deleteHash(id);
		
	}

}
