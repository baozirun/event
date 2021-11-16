/**
* 表单状态验证
*/
export function hasErrors(form){
  form=form || this.form;
  const fieldsError=form.getFieldsError();
  return Object.keys(fieldsError).some(field => {
    if(typeof fieldsError[field] === 'object'){
      const fields=fieldsError[field];
      return Object.keys(fields).some(field =>fields[field] );
    }else{
      return !!fieldsError[field];
    }
  });
}

/**
* 字段验证
*/
export function fieldValid(form,fileName){
  if(!fileName){
    fileName=form;
    form=this.form;
  }
  const { getFieldError, isFieldTouched } = form;
  return isFieldTouched(fileName) && getFieldError(fileName);
}
