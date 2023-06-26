# Banking-Application

#### DEMO

![](https://github.com/praveen-gandreti/Banking-Application/assets/130206094/0323ba79-cce0-4fcf-b9bc-a128b264b984)

This Banking Application contains both Front-End and Back-End.

Front-End :
                Front-End is developed by using "Angular".
                In this application i have created many components -> 
                RegistrationComponent
		LoginComponent
    		HomeComponent
    		EmployeeComponent
    		AdminComponent
    		UserComponent
   		DipositComponent
    		WithdrawComponent
    		BalanceCheckComponent
    		TransfarComponent
    		NotFoundComponent
    		TransferSuccessComponent
    		UpdateAccountComponent
    		DeleteAccountComponent
    		ForgotPasswordComponent
    		AdminPageComponent

		We can access different Components based on Role.
   					Role-USER     ->  can access BalanceCheckComponent and TransferComponent.
					Role-EMPLOYEE -> Can access BalanceCheckComponent, UpdateAccountComponent, DipositComponent, WithdrawComponent.
					Role-ADMIN    -> Can access AdminServiceComponent to create Account for USER.
		
		I have used Angular Material and Bootstrap and NGX Toastr and Css to style the application.

Back-End  :
		Back-End is developed by using "Spring Boot" I have used REST-API to handle the request.

		In this Back-End application we have 2 microservices -> Registration and AccountAndUserCreation.
		I have used synchronous communtication using "feign client" to establish communication between 2 microservices.
		
		Key Features: 
			-> Transaction Management.
			-> MailService.
			-> Exception Handling.
			-> Microservices Communication.
		
		
		

		
    	    
