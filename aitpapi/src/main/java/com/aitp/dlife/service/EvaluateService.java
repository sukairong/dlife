package com.aitp.dlife.service;

import com.aitp.dlife.domain.Evaluate;
import com.aitp.dlife.repository.EvaluateRepository;
import com.aitp.dlife.service.dto.EvaluateDTO;
import com.aitp.dlife.service.mapper.EvaluateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Evaluate.
 */
@Service
@Transactional
public class EvaluateService {

    private final Logger log = LoggerFactory.getLogger(EvaluateService.class);

    private final EvaluateRepository evaluateRepository;

    private final EvaluateMapper evaluateMapper;

    public EvaluateService(EvaluateRepository evaluateRepository, EvaluateMapper evaluateMapper) {
        this.evaluateRepository = evaluateRepository;
        this.evaluateMapper = evaluateMapper;
    }

    /**
     * Save a evaluate.
     *
     * @param evaluateDTO the entity to save
     * @return the persisted entity
     */
    public EvaluateDTO save(EvaluateDTO evaluateDTO) {
        log.debug("Request to save Evaluate : {}", evaluateDTO);
        Evaluate evaluate = evaluateMapper.toEntity(evaluateDTO);
        evaluate = evaluateRepository.save(evaluate);
        return evaluateMapper.toDto(evaluate);
    }

    /**
     * Get all the evaluates.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<EvaluateDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Evaluates");
        return evaluateRepository.findAll(pageable)
            .map(evaluateMapper::toDto);
    }

    /**
     * Get one evaluate by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public EvaluateDTO findOne(Long id) {
        log.debug("Request to get Evaluate : {}", id);
        Evaluate evaluate = evaluateRepository.findOne(id);
        return evaluateMapper.toDto(evaluate);
    }

    /**
     * Delete the evaluate by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Evaluate : {}", id);
        evaluateRepository.delete(id);
    }
}