package vn.edu.iuh.fit.week04.services;

import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.week04.daos.CandidateDao;
import vn.edu.iuh.fit.week04.entities.Candidate;

import java.util.List;

@Component
public class CandidateService {
    private final CandidateDao candidateDao;

    public CandidateService(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    public List<Candidate> getAll() {
        return candidateDao.getAll();
    }

    public boolean create(Candidate candidate) {
        return candidateDao.create(candidate);
    }
}
