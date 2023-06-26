package BANKING.LoginAndRegistration.MIcroServiceCall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import BANKING.LoginAndRegistration.Model.Registration;

@FeignClient(name="account",url="http://localhost:9090/")
public interface CallingMicroservices {
	@PostMapping("create/account")
	public void save(@RequestBody Registration r);

}
