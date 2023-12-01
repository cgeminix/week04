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
public class JobSkill {
    private String moreInformation;
    private SkillLevel skillLevel;
    private Job job;
    private Skill skill;
}
