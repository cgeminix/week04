package vn.edu.iuh.fit.week04.ids;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.week04.entities.Candidate;
import vn.edu.iuh.fit.week04.entities.Skill;

@Setter
@Getter
public class CandidateSkillId {
    private Skill skill;
    private Candidate candidate;
}
