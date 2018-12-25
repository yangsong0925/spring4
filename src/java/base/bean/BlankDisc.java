package base.bean;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BlankDisc implements CompactDisc {

    @NonNull
    private String title;
    @NonNull
    private String artist;
    private List<String> tracks;

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        tracks.stream().forEach(System.out::println);
    }

}
