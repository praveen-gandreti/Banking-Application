package BANKING.LoginAndRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BANKING.LoginAndRegistration.Model.Registration;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration,Long>{

}
