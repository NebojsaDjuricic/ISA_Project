package isa.projekat.booking.service.impl;

import isa.projekat.booking.domain.Branch;
import isa.projekat.booking.repository.BranchRepository;
import isa.projekat.booking.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BranchServiceImpl implements IBranchService {

    @Autowired
    BranchRepository branchRepository;

    @Override
    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Branch findByID(String id) {
        Branch retVal;

        Optional<Branch> byID = branchRepository.findById(id);
        retVal = byID.get();

        return retVal;
    }
}
