import { NgModule } from '@angular/core';

import {
  MatButtonModule,
  MatMenuModule,
  MatToolbarModule,
  MatCardModule,
  MatNativeDateModule,
} from '@angular/material';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatSelectModule} from '@angular/material/select';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatIconModule} from '@angular/material/icon';
@NgModule({
  imports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
	MatFormFieldModule,
	MatInputModule,
	MatDatepickerModule,
	MatSelectModule,
	MatNativeDateModule,
	MatAutocompleteModule,
	ReactiveFormsModule,
	MatCheckboxModule
  ],
  exports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
	MatFormFieldModule,
	MatInputModule,
	MatDatepickerModule,
	MatSelectModule,
	MatNativeDateModule,
	MatAutocompleteModule,
	ReactiveFormsModule,
	MatCheckboxModule
  ]
})
export class MaterialModule {}