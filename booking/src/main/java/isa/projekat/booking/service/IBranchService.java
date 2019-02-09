package isa.projekat.booking.service;

import isa.projekat.booking.domain.Branch;

public interface IBranchService {

    Branch save(Branch branch);
    Branch findByID(String id);
}
