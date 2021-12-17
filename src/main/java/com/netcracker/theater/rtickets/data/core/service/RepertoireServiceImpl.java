package com.netcracker.theater.rtickets.data.core.service;

import com.netcracker.theater.rtickets.data.storage.repository.RepertoireDAO;
import com.netcracker.theater.rtickets.data.storage.entity.Category;
import com.netcracker.theater.rtickets.data.storage.entity.Performance;
import com.netcracker.theater.rtickets.data.storage.entity.Repertoire;
import com.netcracker.theater.rtickets.data.storage.entity.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
        //if (date.equals("") && description.equals("") && name.equals("") && age.equals("99")){
        //    return repertoireDAO.findAll();
        //}
        if (date.equals("")){
            String strDate = "";
        }
        else{
            try {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date dateDate = df.parse(date);
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                String strDate = formatter.format(dateDate);
                List<Repertoire> allRepertoire = repertoireDAO.filterRepertoire(strDate, description, name, age);
                return allRepertoire;
            }
            catch (Exception e){
                System.out.println(e.getCause()+e.getMessage());
            }
        }
        List<Repertoire> allRepertoire = repertoireDAO.filterRepertoire(date, description, name, age);
        return allRepertoire;
    }

    //Added by Ilya
    //Three random Repertoire for main page
    @Override
    @Transactional
    public List<Repertoire> getThreeRandomRepertoire(){
        return repertoireDAO.getThreeRandomRepertoire();
    }


    //Added by Ilya
    //Categories as list for repertoire
    @Override
    @Transactional
    public List<String> getCategoriesByIdOfRepertoire(UUID id){
        List<String> repertoireCategories = new ArrayList<>();
        Set<Category> categories = repertoireDAO.getById(id).getCategories();
        for (Category cat : categories){
            repertoireCategories.add(cat.getName());
        }
        return  repertoireCategories;
    }

    //Added by Ilya
    //
    @Override
    @Transactional
    public Theatre getTheatreByIdOfRepertoire(UUID id){
        Repertoire repertoire = repertoireDAO.getById(id);
        Theatre theatre = new Theatre();
        for (Performance performance : repertoire.getPerformances()){
            if (performance.getTheatre() != null){
                theatre = performance.getTheatre();
                return theatre;
            }
        }
        return theatre;
    }

    //Added by Ilya
    //Get similar repertoire by tags
    @Override
    @Transactional
    public List<Repertoire> getSimilarRepertoire(Set<Category> categories, int amount){
        List<String> categoriesLike = new ArrayList<>();
        for (Category cat : categories){
            categoriesLike.add(cat.getType());
        }
        return repertoireDAO.getSimilarRepertoire(categoriesLike, amount);
    }
}
