package it.engineering.marjanjovanovicbe.service.impl;

import it.engineering.marjanjovanovicbe.dto.TitleDto;
import it.engineering.marjanjovanovicbe.entity.SubjectEntity;
import it.engineering.marjanjovanovicbe.entity.TitleEntity;
import it.engineering.marjanjovanovicbe.service.TitleService;
import it.engineering.marjanjovanovicbe.util.TitleName;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TitleServiceImpl implements TitleService {



//    @Override
//    public List<TitleDto> getAll() {
//        return TitleName.values();
//        return entities.stream().map(entity -> {
//            return subjectMapper.toDto(entity);
//        }).collect(Collectors.toList());
//    }
}
