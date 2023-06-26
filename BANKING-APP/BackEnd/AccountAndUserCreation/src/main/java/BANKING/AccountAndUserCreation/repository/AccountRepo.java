package BANKING.AccountAndUserCreation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BANKING.AccountAndUserCreation.Model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long>{

}
