package org.br.mineradora.scheduler;

import io.quarkus.scheduler.Scheduled;
import org.br.mineradora.service.QuotationService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class QuotationScheduler {

    @Inject
    QuotationService quotationService;

    @Transactional
    @Scheduled(every = "35s", identity = "task-job")
    void schedule() {
        quotationService.getCurrencyPrice();
    }
}
