package com.kripesh.cms.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("studentLoan")
public class StudentLoan implements Loan{
    @Override
    public String getInterest() {
        return "StudentLoan";
    }
}
