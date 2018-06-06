import { NgModule } from '@angular/core';
import {CdkTableModule} from '@angular/cdk/table';

import {
  MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule
} from '@angular/material';
import {MatFormFieldModule} from '@angular/material/form-field';
//import {MatInputModule} from '@angular/material/input';
//import {MatDatepickerModule} from '@angular/material/datepicker';
//import {MatSelectModule} from '@angular/material/select';
//import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
//import {MatCheckboxModule} from '@angular/material/checkbox';
//import {MatIconModule} from '@angular/material/icon';
//import {MatSnackBarModule} from '@angular/material/snack-bar';
//import {MatListModule} from '@angular/material/list';
//import {MatTableModule} from '@angular/material/table';
//import {MatSortModule} from '@angular/material/sort';
//import {MatPaginatorModule} from '@angular/material/paginator';
//import { MatInputModule, MatPaginatorModule, MatProgressSpinnerModule, 
//         MatSortModule, MatTableModule } from "@angular/material";
import {MatDialogModule} from '@angular/material/dialog';

@NgModule({
  imports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
	MatFormFieldModule,
	//MatInputModule,
	MatDatepickerModule,
	MatSelectModule,
	MatNativeDateModule,
	MatAutocompleteModule,
	ReactiveFormsModule,
	MatCheckboxModule,
	MatSnackBarModule,
	MatDialogModule,
	//MatTableModule,
	MatListModule,
	CdkTableModule,
	//MatSortModule,
	//MatPaginatorModule,
	//MatPaginator,
  //MatTableDataSource,
  MatInputModule, MatPaginatorModule, MatProgressSpinnerModule,  MatProgressBarModule, MatSliderModule,
         MatSortModule, MatTableModule, MatGridListModule, MatRadioModule, MatSidenavModule, MatTabsModule,
		 MatDividerModule, MatExpansionModule, MatRippleModule, MatStepperModule, MatTooltipModule,
		  MatButtonToggleModule, MatChipsModule, MatDialogModule, MatSlideToggleModule
  ],
  exports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
	MatFormFieldModule,
	//MatInputModule,
	MatDatepickerModule,
	MatSelectModule,
	MatDialogModule,
	MatNativeDateModule,
	MatAutocompleteModule,
	ReactiveFormsModule,
	MatCheckboxModule,
	MatSnackBarModule,
	MatListModule,
	CdkTableModule, MatTooltipModule,
	//MatTableModule,
	//MatSortModule,
	//MatPaginatorModule,
	//MatPaginator,
  //MatTableDataSource,
  MatInputModule, MatPaginatorModule, MatProgressSpinnerModule, MatGridListModule, MatProgressBarModule, MatSidenavModule, MatSliderModule,
         MatSortModule, MatTableModule, MatDividerModule, MatExpansionModule, MatRadioModule, MatRippleModule, MatSlideToggleModule,
		 MatButtonToggleModule, MatChipsModule, MatDialogModule, MatStepperModule, MatTabsModule
  ]
})
export class MaterialModule {}