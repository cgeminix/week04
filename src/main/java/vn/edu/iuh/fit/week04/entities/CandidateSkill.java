package vn.edu.iuh.fit.week04.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.week04.enums.SkillLevel;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CandidateSkill {
    private String moreInfomation;
    private SkillLevel skillLevel;
    private Candidate candidate;
    private Skill skill;


}
