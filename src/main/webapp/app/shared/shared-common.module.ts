import { NgModule } from '@angular/core';

import { ConcesionarioSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
  imports: [ConcesionarioSharedLibsModule],
  declarations: [JhiAlertComponent, JhiAlertErrorComponent],
  exports: [ConcesionarioSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class ConcesionarioSharedCommonModule {}
