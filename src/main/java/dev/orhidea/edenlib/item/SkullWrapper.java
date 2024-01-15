package dev.orhidea.edenlib.item;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkullWrapper {

    @Getter @Setter private String owner, texture;

}
