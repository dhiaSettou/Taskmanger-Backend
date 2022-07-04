package com.training.training.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProjectDeveloperId implements Serializable {
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "developer_id")
    private Integer developerId;

    public int hashCode() {
        return (int)(developerId + projectId);
    }

    public boolean equals(Object object) {
        if (object instanceof ProjectDeveloperId) {
            ProjectDeveloperId projectDeveloperId = (ProjectDeveloperId) object;
            return (projectDeveloperId.developerId.equals(this.developerId))
                    && (projectDeveloperId.projectId.equals(this.projectId));
        }
        return false;
    }
}
