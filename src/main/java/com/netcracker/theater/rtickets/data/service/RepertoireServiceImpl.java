package com.netcracker.theater.rtickets.data.service;

import com.netcracker.theater.rtickets.data.dao.RepertoireDAO;
import com.netcracker.theater.rtickets.data.entity.Repertoire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

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

    @Override
    @Transactional
    public Repertoire getById(UUID id){return  repertoireDAO.getById(id);}

    @Override
    @Transactional
    public List<Repertoire> getRepertoireWithDates(String date){
        return repertoireDAO.getAllRepertoireWithDates(date);
    }


    //Added by Ilya
    //For Repertoire filtering
    @Override
    @Transactional
    public List<Repertoire> filterRepertoire(String date, String description, String name, String age){
        return repertoireDAO.filterRepertoire(date, description, name, age);
    }

    //Added by Ilya
    //Three random Repertoire for main page
    @Override
    @Transactional
    public List<Repertoire> getThreeRandomRepertoire(){
        return repertoireDAO.getThreeRandomRepertoire();
    }
}
