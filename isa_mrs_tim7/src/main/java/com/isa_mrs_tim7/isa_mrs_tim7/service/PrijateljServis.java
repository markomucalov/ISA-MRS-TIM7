package com.isa_mrs_tim7.isa_mrs_tim7.service;

import com.isa_mrs_tim7.isa_mrs_tim7.domain.Prijatelj;

public interface PrijateljServis {
   Prijatelj dodaj(Prijatelj prijatelj);
   Prijatelj obrisi(Prijatelj prijatelj);
   Prijatelj update(Prijatelj prijatelj);
}
