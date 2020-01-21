package io.redis.jedis.jedisdemo.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import io.redis.jedis.jedisdemo.model.Programmer;

public interface ProgrammerService {
	
	// String
		void setProgrammerAsString(String idKey, String programmer);

		String getProgrammerAsString(String key);
		
		
		// list
		void AddToProgrammersList(Programmer programmer);

		List<Programmer> getProgrammersListMembers();

		Long getProgrammersListCount();
		
		
		// Set
		void AddToProgrammersSet(Programmer ... programmers);

		Set<Programmer> getProgrammersSetMembers();
		
		boolean isSetMember(Programmer programmer);
		
		
		// Hash
		void savePHash(Programmer programmer);

		void updatePHash(Programmer programmer);

		Map<Integer, Programmer> findAllPHash();

		Programmer findPInHash(int id);

		void deletePhash(int id);
		

}
