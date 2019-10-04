package lexicon.se.workshopspringboot.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import lexicon.se.workshopspringboot.entity.AppUser;

public interface AppUserRepo extends CrudRepository<AppUser, Integer>{
	
	Optional<AppUser> findByEmail(String email);

}

