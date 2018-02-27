package io.swagger.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.swagger.model.Projecte;
import io.swagger.model.Tecnic;

@Service
public class ProjecteService {

    private List<Projecte> projectes;

    
    
    public ProjecteService() {
	projectes=new ArrayList<>();
    }
    public List<Projecte> getProjectes() {
        return projectes;
    }

    public void setProjectes(List<Projecte> projectes) {
        this.projectes = projectes;
    }
    public Projecte getProjecte(int index) {
	return projectes.get(index);
    }

    public void addProjecte(int index, Projecte element) {
	projectes.add(index, element);
    }
    public void updateProjecte(int index, Projecte element) {
        projectes.set(index, element);
    }
    
}
