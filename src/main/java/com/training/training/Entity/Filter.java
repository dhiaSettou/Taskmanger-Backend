package com.training.training.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
public class Filter {
    private Long developerId;

}
