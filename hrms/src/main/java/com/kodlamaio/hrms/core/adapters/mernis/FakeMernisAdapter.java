package com.kodlamaio.hrms.core.adapters.mernis;

import com.kodlamaio.hrms.core.adapters.UserRealCheckService;
import com.kodlamaio.hrms.core.adapters.models.MernisPerson;
import org.springframework.stereotype.Component;

//import casper.hrmsApp.mernisService.PCOKPSPublicSoap;

@Component
public class FakeMernisAdapter implements UserRealCheckService{
	//PCOKPSPublicSoap publicSoap = new PCOKPSPublicSoap();

    @Override
    public boolean validate(MernisPerson person) {
       /* try {
            return publicSoap.TCKimlikNoDogrula(
                    Long.parseLong(person.getIdentificationNumber()),
                    person.getFirstName(),
                    person.getLastName(),
                    Integer.parseInt(person.getBirthYear()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }*/
        return true;
    }
}
