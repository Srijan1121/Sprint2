package com.LabAssessment.project1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LabAssessment.project1.entity.Lab;
import com.LabAssessment.project1.exception.LabIdNotFoundException;
import com.LabAssessment.project1.repository.LabRepository;
import com.LabAssessment.project1.service.LabService;

@Service
public class LabServiceImpl implements LabService {
	
    @Autowired
    private LabRepository labRepository;

    @Override
    public Lab createLab(Lab lab) {
        return labRepository.save(lab);
    }

    @Override
    public List<Lab> getAllLabs() {
        return labRepository.findAll();
    }

    @Override
    public Lab getLabById(Long id) {
        return labRepository.findById(id)
                .orElseThrow(() -> new  LabIdNotFoundException("Lab", "id", id));
    }

    @Override
    public Lab updateLab(Long id, Lab lab) {
        Lab existingLab = getLabById(id);
        existingLab.setPcNumber(lab.getPcNumber());
        existingLab.setRoomNumber(lab.getRoomNumber());
        existingLab.setAssignedTask(lab.getAssignedTask());
        existingLab.setAllottedTime(lab.getAllottedTime());
        return labRepository.save(existingLab);
    }

    @Override
    public void deleteLab(Long id) {
        labRepository.deleteById(id);
        
    }
    
    @Override
    public void deleteAllLabs() {
         labRepository.deleteAll();
    }
}

