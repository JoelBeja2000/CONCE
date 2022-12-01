import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ConcesionarioSharedModule } from 'app/shared';
import {
  TrabajadorComponent,
  TrabajadorDetailComponent,
  TrabajadorUpdateComponent,
  TrabajadorDeletePopupComponent,
  TrabajadorDeleteDialogComponent,
  trabajadorRoute,
  trabajadorPopupRoute
} from './';

const ENTITY_STATES = [...trabajadorRoute, ...trabajadorPopupRoute];

@NgModule({
  imports: [ConcesionarioSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    TrabajadorComponent,
    TrabajadorDetailComponent,
    TrabajadorUpdateComponent,
    TrabajadorDeleteDialogComponent,
    TrabajadorDeletePopupComponent
  ],
  entryComponents: [TrabajadorComponent, TrabajadorUpdateComponent, TrabajadorDeleteDialogComponent, TrabajadorDeletePopupComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ConcesionarioTrabajadorModule {}
