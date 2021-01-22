<template>
    <v-flex class="edu06">
         <v-container class="pt-12 pb-12">
             <v-sheet color="#f1f2f2" rounded class="mb-large pa-6">
                <v-form ref="entryForm" id="inquiry-form">
                    <v-card elevation="2" round color="white" >

                        <v-toolbar class="white" dense elevation="0">
                            <v-toolbar-title class="pink--text"><strong>학부모 정보</strong></v-toolbar-title>
                            <v-spacer />
                            <v-icon class="mdi-menu-up">mdi-menu-up</v-icon>
                        </v-toolbar>
                        <div class="pl-3 pr-3">
                            <v-divider class="pink mx-auto" />
                        </div>


                        <v-card-text class="pt-8 hidden-sm-and-down">
                            <div class="d-flex">
                                <div class="d-flex mt-2 text-field-label"><strong>성명</strong></div>
                                <div class="d-flex flex-fill">
                                    <v-text-field maxlength="20" v-model="inquiry.parent_name" placeholder="학부모 성명을 입력해주세요." label="학부모 성명을 입력해주세요." dense outlined counter :rules="[rules.required]" />
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="d-flex mt-2 text-field-label"><strong>생년월일</strong></div>
                                <div class="d-flex flex-fill">
                                    <v-text-field maxlength="10" placeholder="생년월일을 입력해주세요." 
                                        v-model="inquiry.parent_birthday"
                                        label="생년월일을 입력해주세요." dense outlined counter @keyup="birthdayFormatter()" :rules="[rules.birthday]" />
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="d-flex text-field-label"><strong>성별</strong></div>
                                <div class="d-flex flex-fill">
                                    <v-radio-group v-model="inquiry.parent_gender" row class="pa-0 ma-0">
                                        <v-radio value="M" label="남자"></v-radio>
                                        <v-radio value="F" label="여자"></v-radio>
                                    </v-radio-group>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="d-flex mt-2 text-field-label"><strong>연락처</strong></div>
                                <div class="d-flex flex-fill">
                                    <v-text-field maxlength="13" v-model="inquiry.parent_phone" placeholder="연락처를 입력해주세요." label="연락처를 입력해주세요." dense outlined counter @keyup="phoneFormatter()" :rules="[rules.phoneNumber]" />
                                </div>
                            </div>
                        </v-card-text>
                        <v-card-text class="pt-8 hidden-md-and-up">
                            <div class="d-block">
                                <v-text-field maxlength="20" v-model="inquiry.parent_name" placeholder="학부모 성명을 입력해주세요." label="학부모 성명을 입력해주세요." dense outlined counter :rules="[rules.required]" />
                            </div>
                            <div class="d-block">
                                <v-text-field maxlength="10" placeholder="생년월일을 입력해주세요." 
                                    v-model="inquiry.parent_birthday"
                                    label="생년월일을 입력해주세요." dense outlined counter @keyup="birthdayFormatter()" :rules="[rules.birthday]" />
                            </div>
                            <div class="d-block">
                                <v-radio-group v-model="inquiry.parent_gender" row class="pa-0 ma-0">
                                    <template v-slot:label>
                                        <div><strong class="body-1 mr-2 deep-purple--text darken-2">성별</strong></div>
                                    </template>
                                    <v-radio value="M" label="남자"></v-radio>
                                    <v-radio value="F" label="여자"></v-radio>
                                </v-radio-group>                                
                            </div>
                            
                            <div class="d-block">
                                <v-text-field maxlength="13" v-model="inquiry.parent_phone" placeholder="연락처를 입력해주세요." label="연락처를 입력해주세요." dense outlined counter @focus="phoneFormatter()" @keyup="phoneFormatter()" :rules="[rules.phoneNumber]" />
                            </div>
                            
                        </v-card-text>
                    </v-card>
                    <v-divider class="mx-auto mt-4 mb-4" />
                    <v-card elevation="2" round color="white">
                        <v-toolbar class="white" dense elevation="0">
                            <v-toolbar-title class="pink--text"><strong>자녀 정보</strong></v-toolbar-title>
                            <v-spacer />
                            <v-icon class="mdi-menu-up">mdi-menu-up</v-icon>
                        </v-toolbar>
                        <div class="pl-3 pr-3">
                            <v-divider class="pink mx-auto" />
                        </div>
                        <v-card-text class="pt-8 hidden-sm-and-down">

                            <div class="d-flex">
                                <div class="d-flex mt-2 text-field-label"><strong>자녀 이름</strong></div>
                                <div class="d-flex flex-fill">
                                    <v-text-field maxlength="20" v-model="inquiry.name" placeholder="자녀의 이름을 입력해주세요." label="자녀의 이름을 입력해주세요." dense outlined counter :rules="[rules.required]" />
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="d-flex mt-2 text-field-label"><strong>자녀 나이</strong></div>
                                <div class="d-flex flex-fill">
                                    <v-select v-model="inquiry.age" :items="ages" :item-text="'desc'" :item-value="'desc'" dense outlined></v-select>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="d-flex mt-2 text-field-label"><strong>주소</strong></div>
                                <div class="d-flex flex-fill">
                                    <v-row no-gutters >
                                        <v-col class="col-3">
                                            <v-text-field v-model="inquiry.zip_code" readonly dense outlined  placeholder="우편번호" label="우편번호" />
                                        </v-col>
                                        <v-col class="col-9 pl-4">
                                            <v-btn class="pink" dark elevation="1" @click="showAddress">우편번호 검색</v-btn>
                                        </v-col>
                                        <v-col class="col-12">
                                            <v-text-field v-model="inquiry.base_address" readonly dense outlined  placeholder="기본주소" label="기본주소" :rules="[rules.address]" />
                                        </v-col>
                                        <v-col class="col-12">
                                            <v-text-field v-model="inquiry.detail_address" dense outlined placeholder="상세주소를 입력해주세요." label="상세주소를 입력해주세요."/>
                                        </v-col>
                                    </v-row>
                                </div>
                            </div>
                        </v-card-text>

                        <v-card-text class="pt-8 hidden-md-and-up">

                            <div class="d-block">
                                <v-text-field maxlength="20" v-model="inquiry.name" placeholder="자녀의 이름을 입력해주세요." label="자녀의 이름을 입력해주세요." dense outlined counter :rules="[rules.required]"  />
                            </div>
                            <div class="d-block">
                                <v-select v-model="inquiry.age" :items="ages" :item-text="'desc'" :item-value="'age'" placeholder="나이를 선택해주세요." dense outlined></v-select>
                            </div>
                            <div class="d-block">
                                <v-row no-gutters >
                                    <v-col class="col-5">
                                        <v-text-field v-model="inquiry.zip_code" readonly placeholder="우편번호" label="우편번호" maxlength="6" dense outlined  />
                                    </v-col>
                                    <v-col class="col-7 pl-2">
                                        <v-btn class="primary" dark elevation="1" @click="showAddress">우편번호</v-btn>
                                    </v-col>
                                    <v-col class="col-12">
                                        <v-text-field v-model="inquiry.base_address" readonly placeholder="기본 주소지" label="기본 주소지" dense outlined :rules="[rules.address]" />
                                    </v-col>
                                    <v-col class="col-12">
                                        <v-text-field v-model="inquiry.detail_address" placeholder="상세주소를 입력해주세요." label="상세주소를 입력해주세요." dense outlined  />
                                    </v-col>
                                </v-row>
                            </div>
                        </v-card-text>
                    </v-card>
                </v-form>

                <div class="d-flex justify-center pl-12 pr-12">
                    <v-btn x-large class="flex-fill deep-orange dark pa-8 mt-6 mb-6" @click="put()" dark>
                        <strong class="display-1">정보입력</strong>
                    </v-btn>
                </div>
             </v-sheet>
         </v-container>
         <v-dialog
                    v-model="dialog"
                    persistent
                    max-width="1000"
                >
                    <v-card>
                        <v-toolbar color="primary" dense dark>
                            <v-toolbar-title>주소검색</v-toolbar-title>
                            <v-spacer />
                            <v-icon class="mdi-close" @click="closeAddress">mdi-close</v-icon>
                        </v-toolbar>
                            <daum-postcode :on-complete="handleAddress" :key="dialogComponentKey" :on-autoclose="true" height="500px" />
                    </v-card>
                </v-dialog>
        <v-overlay :value="loading">
            <v-progress-circular class="large" indeterminate
                                                    color="amber"></v-progress-circular>
        </v-overlay>

         <v-snackbar
              v-model="api_progress"
              multi-line>
              <v-icon class="mdi-email mr-2">mdi-email</v-icon> {{ api_message }}
        </v-snackbar>

    </v-flex>
</template>

<script>

    import axios from 'axios'
    import daumPostcode from 'vuejs-daum-postcode'

    export default {
        components: { daumPostcode },
        name: "EventComponent6",
        data: () => ({
            inquiry:{
                parent_name:'',
                parent_birthday:'',
                parent_gender: 'M',
                parent_phone: '',
                name:'',
                age: '3세',
                base_address: '',
                detail_address: '',
                zip_code: ''
            },
            ages: [
                {age: 3, desc: '3세'},
                {age: 4, desc: '4세'},
                {age: 5, desc: '5세'},
                {age: 6, desc: '6세'},
                {age: 7, desc: '7세(예비초)'},
                {age: 8, desc: '초등1'},
                {age: 9, desc: '초등2'},
                {age: 10, desc: '초등3'},
                {age: 11, desc: '초등4'},
                {age: 12, desc: '초등5'},
                {age: 13, desc: '초등6'},
            ],
            dialogComponentKey: 1,
            dialog: false,
            loading: false,
            api_progress: false,
            api_message: '',
            rules: {
                required: value => !!value || '필수 입력항목 입니다.',
                address: value => !!value || '우편번호 검색을 통해 주소를 입력해주세요.',
                email: value => {
                    const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
                    return pattern.test(value) || 'e-mail 주소가 잘못되었습니다.'
                },
                birthday: value => {
                    return /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/.test(value) || '생년월일이 잘못되었습니다.'
                },
                phoneNumber: value => {
                    return /^\d{3}-\d{3,4}-\d{4}$/.test(value) || '연락처가 잘못 입력되었습니다.'
                }
            }
        }),
        methods: {
            birthdayFormatter : function(){
                
                let v = this.inquiry.parent_birthday.replace(/[^0-9]/g, '').replace(/\s/gi, '').replace(/-/gi, '');
                let res = ''
                
                if(v.length < 4) res = v;
                else if (v.length >= 4 && v.length <= 6) {
                    res = v.substr(0,4) + '-' + v.substr(4,2);
                    if(v.length == 6) this.inquiry.parent_birthday = this.$moment(res).isValid() ? res : v.substr(0,4);
                    else this.inquiry.parent_birthday = res
                } else if (v.length >= 7) {
                    res = v.substr(0,4) + '-' + v.substr(4,2) + '-' + v.substr(6,2);
                    if(v.length == 8) this.inquiry.parent_birthday = this.$moment(res).isValid() ? res : v.substr(0,4) + '-' + v.substr(4,2);
                    else this.inquiry.parent_birthday = res;
                } 
            },
            closeAddress: function(){
                this.dialog = false;
            },
            showAddress : function(){
                //component :key 값이 상이해지면 초기화됩니다.
                this.dialogComponentKey += 1;
                this.dialog = true;
            },
            handleAddress: function(data){
                //console.log('handleAddress.data', data);
                this.inquiry.zip_code = data.zonecode;
                this.inquiry.base_address = data.address;
                this.closeAddress();
            },
            phoneFormatter : function(){
                let v = this.inquiry.parent_phone.replace(/[^0-9]/g, '').replace(/\s/gi, '');
                let res = ''

                if(v.length < 3) {
                    res = v;
                } else {
                    if(v.substr(0, 2) =='02') {

                        if(v.length <= 5) {//02-123-5678
                            res = v.substr(0, 2) + '-' + v.substr(2, 3)
                        }
                        else if(v.length > 5 && v.length <= 9) {//02-123-5678
                            res = v.substr(0, 2) + '-' + v.substr(2, 3) + '-' + v.substr(5)
                        }
                        else if(v.length > 9) {//02-1234-5678
                            res = v.substr(0, 2) + '-' + v.substr(2, 4) + '-' + v.substr(6)
                        }

                    } else {
                        if(v.length < 8) {
                            res = v
                        }
                        else if(v.length == 8)
                        {
                            res = v.substr(0, 4) + '-' + v.substr(4)
                        }
                        else if(v.length == 9)
                        {
                            res = v.substr(0, 3) + '-' + v.substr(3, 3) + '-' + v.substr(6)
                        }
                        else if(v.length == 10)
                        {
                            res = v.substr(0, 3) + '-' + v.substr(3, 3) + '-' + v.substr(6)
                        }
                        else if(v.length > 10) {
                            res = v.substr(0, 3) + '-' + v.substr(3, 4) + '-' + v.substr(7, 4)
                        }
                    }
                }
                this.inquiry.parent_phone = res;
            },
            put : function(){

                valid : {

                    if(!this.$refs.entryForm.validate()) {
                        break valid;
                    }

                    this.loading = true;
                    let _config = {
                      //baseURL: 'http://localhost:8080/api',
                      headers: {'Content-Type': 'application/json'}
                    };

                    axios.put('/api/event/inquiry', this.inquiry, _config)
                      .then((res) => {
                        console.log('put.response', res);
                        this.loading = false;
                        this.api_message = "문의가 정상적으로 처리되었습니다.";
                        this.api_progress = true;
                      }).catch((err) => {
                        console.error('put.error.response', err);
                        this.api_message = "잠시 후 다시 시도해주시기 바랍니다.";
                        this.api_progress = true;
                      });
                }
            }
        }
    }
</script>

<style scoped>

</style>
