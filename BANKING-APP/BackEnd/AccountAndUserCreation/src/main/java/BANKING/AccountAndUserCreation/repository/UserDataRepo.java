package BANKING.AccountAndUserCreation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BANKING.AccountAndUserCreation.Model.UserData;

@Repository
public interface UserDataRepo extends JpaRepository<UserData,Long>{

	UserData findByUserName(String username);


	


}
