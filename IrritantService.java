package org.edf.cat.mmesi.Irritant.service;

import org.apache.logging.log4j.core.util.UuidUtil;
import org.edf.cat.mmesi.Irritant.model.Irritant;


import java.util.List;
import java.util.UUID;

/**
 * @author TBF053DN
 */
public interface IrritantService {

    List<?> findAll();

    Irritant update(UUID id, Irritant irritant);

    Irritant save(Irritant irritant);

    void delete(UUID id);
}
