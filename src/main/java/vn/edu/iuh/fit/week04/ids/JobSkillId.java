package vn.edu.iuh.fit.week04.ids;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.week04.entities.Job;
import vn.edu.iuh.fit.week04.entities.Skill;

@Getter
@Setter
public class JobSkillId {
    private Job job;
    private Skill skill;
}
