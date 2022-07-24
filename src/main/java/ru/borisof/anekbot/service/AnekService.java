package ru.borisof.anekbot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jvnet.hk2.annotations.Service;
import ru.borisof.anekbot.domain.Anek;
import ru.borisof.anekbot.repo.AnekRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnekService {

    private final AnekRepository repo;

    public Anek getRandomAnek() {
        return repo.findRandomAnek();
    }



}
