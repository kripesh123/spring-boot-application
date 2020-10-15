package com.kripesh.cms.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("homeLoan")
public class HomeLoan implements  Loan{
    @Override
    public String getInterest() {
        return "HomeLoan";
    }
}
