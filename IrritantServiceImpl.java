package org.edf.cat.mmesi.Irritant.service.impl;

import org.edf.cat.mmesi.Irritant.model.Irritant;
import org.edf.cat.mmesi.Irritant.service.IrritantService;
import org.edf.cat.mmesi.Irritant.model.Irritant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author TBF053DN
 */

@Service
public class IrritantServiceImpl implements IrritantService {


    @Override
    public Irritant update(UUID id, Irritant irritant) {
        return null;
    }

    @Override
    public Irritant save(Irritant irritant) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<?> findAll() {
        return null;
    }


}
