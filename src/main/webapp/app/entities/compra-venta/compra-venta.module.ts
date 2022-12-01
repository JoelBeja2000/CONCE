import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ConcesionarioSharedModule } from 'app/shared';
import {
  CompraVentaComponent,
  CompraVentaDetailComponent,
  CompraVentaUpdateComponent,
  CompraVentaDeletePopupComponent,
  CompraVentaDeleteDialogComponent,
  compraVentaRoute,
  compraVentaPopupRoute
} from './';

const ENTITY_STATES = [...compraVentaRoute, ...compraVentaPopupRoute];

@NgModule({
  imports: [ConcesionarioSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    CompraVentaComponent,
    CompraVentaDetailComponent,
    CompraVentaUpdateComponent,
    CompraVentaDeleteDialogComponent,
    CompraVentaDeletePopupComponent
  ],
  entryComponents: [CompraVentaComponent, CompraVentaUpdateComponent, CompraVentaDeleteDialogComponent, CompraVentaDeletePopupComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ConcesionarioCompraVentaModule {}
