package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.dao.RepertoireDAO;
import com.netcracker.theater.rtickets.data.entity.Repertoire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RepertoireServiceImpl implements RepertoireService{
    @Autowired
    RepertoireDAO repertoireDAO;
    @Override
    @Transactional
    public List<Repertoire> getAllRepertoire() {
        return repertoireDAO.findAll();
    }

    @Override
    public void saveRep(Repertoire repertoire) {
        repertoireDAO.save(repertoire);
    }

}
