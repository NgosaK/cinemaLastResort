package constructioncompany.services.Impl;

import constructioncompany.domain.ScreeningRoom;
import constructioncompany.respository.ScreeningRoomRepository;
import constructioncompany.services.ScreeningRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2015/09/24.
 */
@Service
public class ScreeningRoomServiceImpl implements ScreeningRoomService {
    @Autowired
    private ScreeningRoomRepository repository;

    @Override
    public List<ScreeningRoom> getScreeningRooms() {
        List<ScreeningRoom> allSchedules= new ArrayList<ScreeningRoom>();
        Iterable<ScreeningRoom> schedules= repository.findAll();

        for(ScreeningRoom schedule: schedules)
        {
            allSchedules.add(schedule);
        }

        return allSchedules;
    }

    @Override
    public ScreeningRoom getScreeningRoom(long id) {
        return repository.findOne(id);    }

    @Override
    public ScreeningRoom addScreeningRoom(ScreeningRoom screeningRoom) {
        return repository.save(screeningRoom);    }

    @Override
    public void removeScreeningRoom(ScreeningRoom screeningRoom) {
        repository.delete(screeningRoom);

    }

    @Override
    public ScreeningRoom updateScreeningRoom(ScreeningRoom screeningRoom) {
        return repository.save(screeningRoom);
    }
}
