package constructioncompany.factory;

import constructioncompany.domain.ScreeningRoom;

import java.util.Map;

/**
 * Created by User on 2015/09/24.
 */
public class ScreeningRoomFactory {

    public static ScreeningRoom createScreeningRoom(
            Map<String,String> values, long code)
    {
        ScreeningRoom screeningRoom=new ScreeningRoom
                .Builder(code)
                .type(values.get("type"))
                .size(values.get("size"))
                .build();

        return screeningRoom;
    }
}
